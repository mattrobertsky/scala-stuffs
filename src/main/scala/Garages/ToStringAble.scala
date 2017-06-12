package Garages

/**
  * Created by Administrator on 12/06/2017.
  */
trait ToStringAble {
  override def toString: String = {
    myToString
  }
  def myToString: String
}
