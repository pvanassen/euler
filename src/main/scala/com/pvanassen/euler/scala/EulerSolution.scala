package com.pvanassen.euler.scala

import java.io.File
import java.nio.file.Files

import net.ruippeixotog.scalascraper.browser.Browser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import org.jsoup.nodes.Element
/**
 *
 * @author Paul van Assen
 *
 */
trait EulerSolution {
  def problemNumber: Int
  final def run(): Unit = {
    println("************************************************\n")
    println(s"Problem ${problemNumber}\n")
    println(getDescription)
    println("\n************************************************\n")
    println(s"Answer: ${execute()}")
  }

  private def getDescription(): String = {
    import scala.collection.JavaConversions._
    val fileDesc = new File(s"euler-${problemNumber}")
    if (fileDesc.exists()) {
      return Files.readAllLines(fileDesc.toPath).mkString("\n")
    }
    val browser = new Browser
    val doc = browser.get(s"https://projecteuler.net/problem=${problemNumber}")
    val description = doc.getElementsByClass("problem_content").text()
    Files.write(fileDesc.toPath, description.getBytes)
    return description
  }
  protected def execute(): String

}