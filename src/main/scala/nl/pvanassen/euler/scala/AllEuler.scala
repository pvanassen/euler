package nl.pvanassen.euler.scala

import org.clapper.classutil.{ClassFinder, ClassInfo}
/**
 *
 * @author Paul van Assen
 *
 */
object AllEuler {
  def main(args: Array[String]): Unit = {

    ClassFinder()
      .getClasses
      .filter(_.isConcrete)
      .filter(filter)
      .map(clz => {
        getClass.getClassLoader.loadClass(clz.name).newInstance() match {
          case eulerSolution: EulerSolution => eulerSolution
          case _ => throw new ClassCastException
        }
      })
      .sortBy(eulerSolution => eulerSolution.problemNumber)
      .foreach(eulerSolution => eulerSolution.run())
  }

  def filter(classInfo: ClassInfo): Boolean =
    classInfo
      .interfaces
      .exists(interface => interface.contains("EulerSolution"))

}
