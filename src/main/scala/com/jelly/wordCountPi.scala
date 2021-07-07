package com.jelly

import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}
import org.apache.flink.api.scala._

object wordCountPi {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val inputPath = "D:\\program\\FlinkPracticeOne\\src\\main\\resources\\hello.txt"
    val inputDS: DataSet[String] = env.readTextFile(inputPath)

    val value: AggregateDataSet[(String, Int)] = inputDS.flatMap(_.split(" ")).map((_, 1)).groupBy(0).sum(1)
    value.print()
  }
}
