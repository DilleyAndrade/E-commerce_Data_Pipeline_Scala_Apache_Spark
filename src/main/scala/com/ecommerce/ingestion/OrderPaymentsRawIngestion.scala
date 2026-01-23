package com.ecommerce.ingestion

import com.ecommerce.utils.{CsvReaderUtil, StructSchemaUtil}
import java.time.LocalDate

object OrderPaymentsRawIngestion {

  val tableName = "order_payments"
  val tableSchema = StructSchemaUtil.order_payments_schema
  val actual_data = LocalDate.now()
  private val csv_path = s"data_source/${tableName}/olist_${tableName}_dataset.csv"
  private val dstn_path = s"data/raw/${tableName}/${tableName}-${actual_data}"

  def orderPaymentsRawIngestion(): Unit = {
    try{
      println(s"Lendo tabela ${tableName}.")

      val df_orders = CsvReaderUtil.loadTable(",", tableSchema , csv_path)
      df_orders.show(5)

      println(s"Salvando tabela ${tableName} na camada Raw, no diretório: ${dstn_path}")

      df_orders
        .write
        .mode("overwrite")
        //.partitionBy()
        .option("compression", "snappy")
        .parquet(dstn_path)

      println(s"Tabela ${tableName} Raw salva com sucesso!")

    }catch{
      case e: Exception => println(s"Erro ao salvar tabela ${tableName} no destino. ERROR: ${e.getMessage}")
    }
  }
}
