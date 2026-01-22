package com.ecommerce.execute

import com.ecommerce.ingestion.{OrderPaymentRawIngestion, OrdersRawIngestion, ProductsRawIngestion}

object BatchExecute {
  def main(args:Array[String]): Unit = {
    OrdersRawIngestion.df_orders.show()
    OrdersRawIngestion.df_orders.printSchema()

    ProductsRawIngestion.df_products.show()
    ProductsRawIngestion.df_products.printSchema()

    OrderPaymentRawIngestion.df_order_payments.show()
    OrderPaymentRawIngestion.df_order_payments.printSchema()
  }
}
