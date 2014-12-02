package main.scala

/**
 * Created by junius on 14-11-17.
 */

trait Service{
  def doAction(): Unit
}

trait AfterServiceAspect extends Service{
  abstract override def doAction(): Unit = {
    println("after doAction ... ");
    super.doAction();
  }
}

trait BeforeServiceAspect extends Service{
  abstract override def doAction(): Unit = {
    println("before doAction ... " )
    super.doAction();
  }
}



class ServiceImpl extends Service{
  override def doAction(){
    println("do job");
    //super.doAction();
  }
}

object TraitCombination {
  def main (args: Array[String]) {
    // call each implementation from right to left. trait stack.
    val s = new ServiceImpl with BeforeServiceAspect with AfterServiceAspect

    //junius it is a multiple inheritance case. and you can see three doActions
    // are called according to the order.
    s.doAction()
  }
}
