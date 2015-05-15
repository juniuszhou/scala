package HackerRank

/*
100 200
14090 14846 6200 14956 10824 9186 15395 2773 1676 13892 7043 10199 4053 612 9993 15250 2288 5844 5527 290 3707 3585 9645 3089 11544 13518 10513 6881 13368 766 6376 3413 2119 1194 3882 2630 8560 14650 3251 2439 11216 8714 12754 10098 7201 8873 11018 7986 13268 1337 1079 8276 8990 1837 13661 12147 7747 8428 2947 5016 5385 1499 7395 4677 10678 15056 11698 9463 7874 13761 12000 9307 928 4361 4215 9869 4828 6707 125 6555 5212 12613 13107 4518 11844 8129 5685 12441 14285 11408 6021 14480 2015 428 9749 12953 12277 10383 5 7587
2 2 6 5 7 7 3 1 7 6 5 1 4 1 7 2 8 2 3 3 8 6 1 1 4 6 1 8 4 5 8 2 7 4 8 1 4 6 5 1 4 5 7 5 7 2 8 4 5 5 6 6 7 5 7 3 3 6 5 7 5 6 2 6 7 1 3 8 2 8 4 6 7 3 6 3 3 2 4 8 5 5 8 6 8 4 7 4 6 4 6 4 7 1 2 4 1 5 2 6
196
15248
6994
9131
849
13721
11739
9661
13247
15105
536
11536
10408
1477
1524
10469
4530
7669
2673
10386
12513
6562
15332
6045
5444
12954
9737
12306
10521
11432
8763
8088
1917
1880
10568
4609
9029
8779
5907
1640
4544
1430
4519
1842
3160
4092
10416
2097
8582
14419
13438
6338
2347
259
5241
5692
11731
4101
2293
4939
4022
12827
4387
8039
9984
7262
6960
6939
5892
10964
606
10632
6595
6915
11571
9809
12163
7193
4758
180
4686
24
9297
3453
14100
13486
662
3050
1498
7339
1873
13055
9994
10297
5456
13910
15218
4965
1296
8047
8334
11167
3749
14122
13041
10261
6098
10935
4360
2978
3903
13201
8506
5634
5147
11198
9373
1927
1521
11020
1522
574
8868
13903
13489
4221
5530
13615
2669
1235
2356
7364
12916
11958
6467
1674
2441
10340
12696
8975
6162
4404
4325
2852
5684
13739
5218
5679
12080
5727
6003
4784
9105
14434
8224
8513
14120
4810
10956
2232
13488
14178
3178
11564
4804
8718
3472
1932
12322
263
4053
8661
13917
550
1517
9366
982
6142
2320
2945
8134
9115
1796
13077
5643
13800
270
12557
13611
8683
7982
5379
984
11227
11486
14386
3495
13650
12230
7354
 */

/*
7
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
4
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
7
70
7
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
4
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
70
4
70
70
70
70
70
70
70
70
70
70
70
70
70
 */
import scala.util.Sorting

object Solution3 {
  case class Init(init: Int, index: Int)
  class InitCompare extends Ordering[Init]{
    def compare(a: Init, b: Init): Int = - (a.init compare b.init)
  }

  case class Node(var indexOfInit: Int,var indexOfRate: Int)

  class NodeCompare extends Ordering[Init]{
    def compare(a: Init, b: Init): Int = a.init compare b.init
  }

  case class Rate(rate: Int, index: Int)
  class RateCompare extends Ordering[Rate]{
    def compare(a: Rate, b: Rate): Int = -(a.rate compare b.rate)
  }

  def main(args: Array[String]) {

    val l = readLine().split(" ").map(_.toInt).toArray
    val (n, q) = (l(0),l(1))
    //println(n," ", q)
    val initList = readLine().split(" ").map(_.toInt).toList
    val rateList = readLine().split(" ").map(_.toInt).toList

    def getSortInit(): Array[Init] = {
      var index = 0
      val unsorted = initList.map(i => {
        val init = Init(i, index)
        index += 1
        init
      }).toArray
      Sorting.quickSort(unsorted)(new InitCompare)
      unsorted
    }

    val initArray = getSortInit()
    //initArray.foreach(print)
    //println()

    def getSortRate(): Array[Rate] = {
      var index = 0
      val unsorted = rateList.map(i => {
        val init = Rate(i, index)
        index += 1
        init
      }).toArray
      Sorting.quickSort(unsorted)(new RateCompare)
      unsorted
    }

    val rateArray = getSortRate()
    //rateArray.foreach(print)
    //println()

    val nodeArray = new Array[Node](n)
    (0 until n).foreach(i => nodeArray(i) = Node(-1,-1))

    (0 until n).foreach(i => nodeArray(initArray(i).index).indexOfInit = i)
    (0 until n).foreach(i => nodeArray(rateArray(i).index).indexOfRate = i)

    //nodeArray.foreach(print)
    //println()
    def findMax(day: Int): Int = {
      var tRateArray = nodeArray(initArray(0).index).indexOfRate
      var tInitArray = nodeArray(rateArray(0).index).indexOfInit

      var ir = 0 // index in rate array
      var ii = 0 // index in init array.
      var res = -1 // index in node array.
      //println(tRateArray,tInitArray)

      while(ir < tRateArray && ii < tInitArray){
        val initInRate = rateArray(nodeArray(initArray(ii).index).indexOfRate).rate
        val rateInInit = initArray(nodeArray(rateArray(ir).index).indexOfInit).init
        val v1 = initArray(ii).init + initInRate * day
        val v2 = rateArray(ir).rate * day + rateInInit
        //println(v1,v2,initInRate,rateInInit)
        if(v1 > v2){ // the node in init array win.
          res = initArray(ii).index
          ir += 1
          if(initInRate < tInitArray) tInitArray = initInRate
        }
        else{
          res = rateArray(ir).index
          ii += 1
          if(rateInInit < tRateArray) tRateArray = rateInInit
        }
      }

      res
    }
    // val qq = readLine().split(" ").map(_.toInt)
    (0 until q).foreach(i => println(findMax(readLine().toInt)+1))
  }
}