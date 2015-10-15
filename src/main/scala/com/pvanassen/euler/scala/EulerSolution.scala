package com.pvanassen.euler.scala
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
    val browser = new Browser
    val doc = browser.get(s"https://projecteuler.net/problem=${problemNumber}")
    val description = doc.getElementsByClass("problem_content").text()
    println("************************************************\n")
    println(s"Problem ${problemNumber}\n")
    println(description)
    println("\n************************************************\n")
    println(s"Answer: ${execute()}")
  }
  protected def execute(): String
}