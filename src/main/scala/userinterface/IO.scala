package userinterface

import scala.io.StdIn

sealed trait IO[A] { self =>

  def run: A

  def map[B](f: A => B): IO[B] = new IO[B] {
    def run = f(self.run)
  }

  def flatMap[B](f: A => IO[B]): IO[B] = new IO[B] {
    def run = f(self.run).run
  }

}

object IO {

  def apply[A](a: => A): IO[A] = new IO[A] { def run = a}

  def readLine: IO[String] = IO { StdIn.readLine }

  def printLine(msg: String): IO[Unit] = IO { println(msg) }

}
