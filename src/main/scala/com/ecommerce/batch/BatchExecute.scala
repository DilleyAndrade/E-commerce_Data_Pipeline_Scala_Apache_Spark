package com.ecommerce.batch

import com.ecommerce.ingestion.{CustomersRawIngestion, OrderItemsRawIngestion, OrderPaymentsRawIngestion, OrdersRawIngestion, ProductsRawIngestion}
import com.ecommerce.refined.CustomersTrustedTransform

object BatchExecute {
  def main(args:Array[String]): Unit = {

    def rawIngestionProcess(): Unit = {
      println("Iniciando ingestão da camada Raw!")

      CustomersRawIngestion.customersRawIngestion()

      println("Ingestão da camada Raw finalizada com sucesso!")
    }
    //rawIngestionProcess()


  }
}
