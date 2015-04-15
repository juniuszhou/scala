package Recommedation

/**
 * http://www.cnblogs.com/breezedeus/archive/2012/04/10/2440488.html
term frequency–inverse document frequency
 */
object tfidf {
  val numberOfDocument = 100
  val Document = new Array[Array[String]](numberOfDocument) // we have 100 document.
  val numberOfVocabulary = 10000
  val vocabulary = new Array[String](numberOfVocabulary) // we have 10000 words

  // how to represent a document, each item is weight of each word.
  // the simple way to give each weight a value is the one or times of a word
  // appeared in document one. 0 for not appeared.
  val docOne = new Array[Double](numberOfVocabulary) // document one

  // tf the ith word appeared in doc how many times
  def tf(i: Int, doc: Array[String]) : Int = doc.count(s => s == vocabulary(i))

  // tfidf the most popular way to give the value for each weight.
  def tfidf(i: Int, j: Int): Double = {
    // nk how many document include ith word
    val nk = Document.count(arr => arr.contains(vocabulary(i)))
    // we have 100 ducument
    tf(i, Document(j)) * Math.log(numberOfDocument) / Math.log(nk)
  }

  def weight(i:Int, j: Int): Double = {
    var sum = 0.0
    (0 until vocabulary.size).foreach(k => {
      sum += Math.pow(tfidf(k, j), 2)
    })
    tfidf(i,j) / Math.sqrt(sum)
  }

  // assgin value for each weight. we think the docOne is the first doc in documents.
  (0 until vocabulary.size).foreach(i => docOne(i) = weight(i, 0))

}
