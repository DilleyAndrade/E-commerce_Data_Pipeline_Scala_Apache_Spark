package com.ecommerce.batch

import com.ecommerce.ingestion.{CustomersRawIngestion, OrderItemsRawIngestion, OrderPaymentsRawIngestion, OrdersRawIngestion, ProductsRawIngestion}

object BatchExecute {
  def main(args:Array[String]): Unit = {

    def rawIngestionProcess(): Unit = {
      println("Iniciando ingestão da camada Raw!")

      CustomersRawIngestion.customersRawIngestion()
      OrderItemsRawIngestion.orderItemsRawIngestion()
      OrderPaymentsRawIngestion.orderPaymentsRawIngestion()
      OrdersRawIngestion.ordersRawIngestion()
      ProductsRawIngestion.productsRawIngestion()

      println("Ingestão da camada Raw finalizada com sucesso!")
    }
    rawIngestionProcess()

  }
}
