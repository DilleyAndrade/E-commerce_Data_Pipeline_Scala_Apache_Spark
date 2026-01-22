package com.ecommerce.execute

import com.ecommerce.ingestion.{OrdersRawIngestion, ProductsRawIngestion}

object BatchExecute {
  def main(args:Array[String]): Unit = {
    OrdersRawIngestion.df_orders.show()
    OrdersRawIngestion.df_orders.printSchema()

    ProductsRawIngestion.df_products.show()
  }
}
