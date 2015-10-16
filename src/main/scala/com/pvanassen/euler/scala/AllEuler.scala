package com.pvanassen.euler.scala

import org.clapper.classutil.ClassFinder
/**
 *
 * @author Paul van Assen
 *
 */
object AllEuler {
  def main(args: Array[String]): Unit = {
    val finder = ClassFinder()
    finder.getClasses.filter(_.isConcrete).filter(!_.interfaces.filter(i => i.contains("EulerSolution")).isEmpty).map(clz => {
      getClass().getClassLoader.loadClass(clz.name).newInstance() match {
        case eulerSolution: EulerSolution => eulerSolution
        case _ => throw new ClassCastException
      }
    }).sortBy(eulerSolution => eulerSolution.problemNumber).filter(p => p.problemNumber > 2).foreach(eulerSolution => eulerSolution.run())
  }
}
