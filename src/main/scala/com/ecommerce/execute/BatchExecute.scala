package com.ecommerce.execute

import com.ecommerce.ingestion.{CustomersRawIngestion, OrderItemsRawIngestion, OrderPaymentsRawIngestion, OrdersRawIngestion, ProductsRawIngestion}

object BatchExecute {
  def main(args:Array[String]): Unit = {
    OrdersRawIngestion.df_orders.show()
    OrdersRawIngestion.df_orders.printSchema()

    println("Exportando dados")
    OrdersRawIngestion.ordersRawIngestion()
  }
}
