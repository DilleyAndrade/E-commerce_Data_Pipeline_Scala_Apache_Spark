package com.ecommerce.execute

import com.ecommerce.ingestion.{CustomersRawIngestion, OrderItemsRawIngestion, OrderPaymentsRawIngestion, OrdersRawIngestion, ProductsRawIngestion}

object BatchExecute {
  def main(args:Array[String]): Unit = {
    OrdersRawIngestion.df_orders.show()
    OrdersRawIngestion.df_orders.printSchema()

    ProductsRawIngestion.df_products.show()
    ProductsRawIngestion.df_products.printSchema()

    OrderPaymentsRawIngestion.df_order_payments.show()
    OrderPaymentsRawIngestion.df_order_payments.printSchema()

    CustomersRawIngestion.df_customers.show()
    CustomersRawIngestion.df_customers.printSchema()

    OrderItemsRawIngestion.df_order_items.show()
    OrderItemsRawIngestion.df_order_items.printSchema()
  }
}
