package com.ecommerce.execute

import com.ecommerce.ingestion.OrdersRawIngestion

object BatchExecute {
  def main(args:Array[String]): Unit = {
    OrdersRawIngestion.df_orders.show()
    OrdersRawIngestion.df_orders.printSchema()
  }
}
