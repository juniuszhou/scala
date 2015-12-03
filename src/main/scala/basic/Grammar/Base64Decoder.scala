package basic.Grammar

/**
 * Created by juzhou on 10/27/2015.
 */

import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.util.zip.GZIPInputStream
// import org.apache.commons.codec.binary.Base64
import scala.util.{Try, Failure, Success}


object Base64Decoder {
  //compressedByteArray <- Try(Base64.decodeBase64(compressed)) recoverWith { case err => Failure(err) }

  //bis <- Try(new ByteArrayInputStream(compressedByteArray)) recoverWith { case err => Failure(err) }

  def decodeUnzip(compressed: String): Try[String] = {
    //val compressedByteArray = Base64.decodeBase64(compressed)
    val compressedByteArray = "asdf".getBytes
    val bis = new ByteArrayInputStream(compressedByteArray)

    for {
      gis <- Try(new GZIPInputStream(bis)) recoverWith {
        case err => bis.close()
          Failure(err)
      }

      br <- Try { new BufferedReader(new InputStreamReader(gis, "UTF-8")) } recoverWith {
        case err =>
          bis.close()
          gis.close()
          Failure(err)
      }

      result <- Try(br.readLine()) recoverWith {
        case err =>
          bis.close()
          gis.close()
          br.close()
          Failure(err)
      }

      non <- {
        bis.close()
        gis.close()
        br.close()
        Success()
      }
    } yield result
  }

  def main (args: Array[String]) {
    println(decodeUnzip("H4sIAAAAAAAAAJWS3WrjMBCF30XXVZD879wtDRRDYEvdXC29UKRxIqpIXkkOhNJ335GThlC6dFcGg8bfGc051hsJk5QQAllGP8EdiV7YIGTUzq7d7vk0AlmSR6+ltrsfVphT0IF8xno3eQn9KUQ4IL52aof4h+ootBFbbXQ89eCPWgI28PB7ghA7hXzBClBDrWhZtZIWZS7pNq8lzWrBeAm5qvIcJVMA3+OoeGa3Qhm/LMoznt2+bhbK0pRHPPt/NDf2ZlndwMBqpWirlKDFIBraNGVD5aC2MAw4dstQJo0GG2dFZyN4zKvv18/oEz+qyYvUkCw5WmyvEVwy/ntoT2duDi2Mzgb4B8kZRM3eoXRJxj2YYLajCCFyli1ehT8IxBcWUmewaoPxdmPKKKsXDJ8UxOi0jT+HXhg8kM/BHMEk9GGTfDI0vQf5qtEWyfBvUc5oVpBL2U3xWsfM54wm78HKE9Y3/Yp8tAQfOju4R/BPzh3WOg39640INZl47yaLW/5+97nwkvxFMCuIaD7MkrmQ7lVZsbaoa7wB52SShUGYAKnPlSqyrPoWwluRN231DdXysmD8C+jl/Q+QPAIbaAMAAA==").get)
  }
}