package com.ecommerce.refined

import com.ecommerce.utils.SparkSessionUtil
import java.time.LocalDate


object CustomersTrustedTransform {

  def customersTrustedTransform(): Unit = {

    val tableName = "customers"
    val actualData = LocalDate.now()
    val origPath = s"data/raw/${tableName}/${tableName}-${actualData}"
    val dstnPath = s"data/trusted/${tableName}/${tableName}-${actualData}"

    try{

      println(s"Lendo tabela ${tableName} da camada Raw!")

      val dfCustomers = SparkSessionUtil.spark
        .read
        .parquet(origPath)

      dfCustomers.show()

      println(s"Removendo valores duplicados de ${tableName}!")
      val custumersDropDup = dfCustomers.dropDuplicates()

      println(s"Removendo valores nulos de ${tableName}!")
      val customersDropNull = custumersDropDup.na.drop()

      println(s"Salvando tabela ${tableName} na camada Trusted, no diretório: ${dstnPath}")

      customersDropNull
        .write
        .mode("overwrite")
        .option("cmopression", "snappy")
        .parquet(dstnPath)

      println(s"Tabela ${tableName} Raw salva com sucesso!")

    }catch{
      case e: Exception => println(s"Erro ao salvar tabela ${tableName} no destino. ERROR: ${e.getMessage}")
    }
  }
}
