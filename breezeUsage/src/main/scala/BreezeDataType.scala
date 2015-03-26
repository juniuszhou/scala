import _root_.breeze.collection.mutable.SparseArray
import _root_.breeze.linalg.CSCMatrix
import _root_.breeze.linalg.DenseVector
import _root_.breeze.linalg.SparseVector

object BreezeDataType{
  def main (args: Array[String]) {
    println("I am OK")

    val indexArray = Array(1,2,3,4,5,6)
    val dataArray = Array(1.0,2.0,3.0,4.0,5.0,6.0)

    // dense matrix and not init it. just give the dimension.
    val bldm = new  breeze.linalg.DenseMatrix[Double](2,3)

    // sparse vector with data.
    val blsm = new SparseVector[Double](indexArray, dataArray, 100)

    // dense vector
    val bldv = DenseVector.zeros[Double](10)

    // sparse array just give the size.
    val blsa = new SparseArray[Double](100)

    //
    // val blsm = new CSCMatrix[]()
  }
}