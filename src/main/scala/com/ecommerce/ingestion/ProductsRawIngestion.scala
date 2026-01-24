package com.ecommerce.ingestion

import com.ecommerce.utils.{CsvFilesUtil, StructSchemaUtil}

import java.time.LocalDate

object ProductsRawIngestion {

  val tableName = "products"
  val tableSchema = StructSchemaUtil.productsSchema
  val actualData = LocalDate.now()
  private val csvPath = s"data_source/${tableName}/olist_${tableName}_dataset.csv"
  private val dstnPath = s"data/raw/${tableName}/${tableName}-${actualData}"

  def customersRawIngestion(): Unit = {
    try{
      println(s"Lendo tabela ${tableName}.")

      val dtfe = CsvFilesUtil.loadTable(",", tableSchema , csvPath)
      dtfe.show(5)

      println(s"Salvando tabela ${tableName} na camada Raw, no diretório: ${dstnPath}")

      dtfe
        .write
        .mode("overwrite")
        //.partitionBy()
        .option("compression", "snappy")
        .parquet(dstnPath)

      println(s"Tabela ${tableName} Raw salva com sucesso!")

    }catch{
      case e: Exception => println(s"Erro ao salvar tabela ${tableName} no destino. ERROR: ${e.getMessage}")
    }
  }
}