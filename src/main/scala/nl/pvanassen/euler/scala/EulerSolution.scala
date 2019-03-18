package nl.pvanassen.euler.scala

import java.io.File
import java.nio.file.Files

import net.ruippeixotog.scalascraper.browser.JsoupBrowser

import scala.collection.JavaConverters._
/**
 *
 * @author Paul van Assen
 *
 */
trait EulerSolution {
  def problemNumber: Int
  final def run(): Unit = {
    println("************************************************\n")
    println(s"Problem $problemNumber\n")
    println(getDescription)
    println("\n************************************************\n")
    println(s"Answer: ${execute()}")
  }

  private def getDescription(): String = {
    val fileDesc = new File(s"euler-$problemNumber")
    if (fileDesc.exists()) {
      return asScalaBuffer(Files.readAllLines(fileDesc.toPath)).mkString("\n")
    }
    val browser = new JsoupBrowser
    val doc = browser.get(s"https://projecteuler.net/problem=$problemNumber")
    val description = doc.underlying.getElementsByClass("problem_content").text()
    Files.write(fileDesc.toPath, description.getBytes)
    return description
  }
  protected def execute(): String

}