import java.util._

object MethodOFSimpleInteration {
  var i: Int = _
  var j: Int = _
  var k: Int = _
  var iter: Int = 0

  var Ymova_A: Array[Array[Double]] = Array(Array(21, -5.6, 4, -8.3),
                                            Array(3.4, -14.6, -6.5, 7),
                                            Array(5, 1.6, -41.3, 2.3),
                                            Array(3.9, -12.6, 2.4, -31))

  var Ymova_B: Array[Double] = Array(3.4, 2.4, 6.9, 1.4)
  var x: Array[Double] = new Array[Double](4)
  var xo: Array[Double] = new Array[Double](4)
  var tmp: Double = _
  var eps: Double = _

  def main(args: Array[String]): Unit = {
    for (i <- 0 to 3)
    {
      for (j <- 0 to 3)
      {
        System.out.print(Ymova_A(i)(j))
        System.out.print("\t")
      }
      System.out.print(Ymova_B(i))
      System.out.print("\n")
    }

    for (j <- 0 to 3)
    {
      Ymova_B(j) = Ymova_B(j) / Ymova_A(j)(j)
    }

    for (i <- 0 to 3)
    {
      tmp = Ymova_A(i)(i)
      j = 0
      for (j <- 0 to 3)
      {
        Ymova_A(i)(j) = -Ymova_A(i)(j) / tmp
      }
      Ymova_A(i)(i) = 0
    }

    for (i <- 0 to 3)
    {
      x(i) = Ymova_B(i)
      xo(i) = Ymova_B(i)
    }
    iter += 1
    System.out.print("\n")
    System.out.print("Iтерацiя:")
    System.out.print(iter)
    System.out.print("\n")
    for (i <- 0 to 3)
    {
      System.out.print("x[")
      System.out.print(i + 1)
      System.out.print("]=")
      System.out.print(x(i))
      System.out.print("\n")
    }
    System.out.print("\n")
    do
    {
      iter += 1
      for (i <- 0 to 3)
      {
        x(i) = 0
        for (j <- 0 to 3)
        {
          x(i) = x(i) + Ymova_A(i)(j) * xo(j)
        }
        x(i) = x(i) + Ymova_B(i)
      }
      eps = Math.abs(x(0) - xo(0))
      for (i <- 0 to 3)
      {
        if (Math.abs(x(i) - xo(i)) > eps)
        {
          eps = Math.abs(x(i) - xo(i))
        }
        xo(i) = x(i)
      }
      System.out.print("Iтерацiя:")
      System.out.print(iter)
      System.out.print("\n")
      for (i <- 0 to 3)
      {
        System.out.print("x[")
        System.out.print(i + 1)
        System.out.print("]=")
        System.out.print(x(i))
        System.out.print("\n")
      }
      System.out.print("\n")
    } while (eps > 0.001)
    System.out.print("Рiшення")
    System.out.print("\n")

    for (i <- 0 to 3)
    {
      System.out.print("x[")
      System.out.print(i + 1)
      System.out.print("]=")
      System.out.print(x(i))
      System.out.print("\n")
    }
    new Scanner(System.in).nextLine()
  }
}
