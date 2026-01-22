package com.ecommerce.ingestion

import com.ecommerce.utils.{SparkSessionUtil, StructSchemaUtil}
import java.time.LocalDate

object ProductsRawIngestion {

  val actual_data = LocalDate.now()
  private val orig_path = "data_source/products/olist_products_dataset.csv"
  private val dstn_path = s"data/raw/products/products-${actual_data}"

  val df_products = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .schema(StructSchemaUtil.products_schema)
    .csv(orig_path)

  def productsRawIngestion(): Unit = {
    df_products
      .coalesce(1)
      .write
      .mode("append")
      .option("compression", "snappy")
      .parquet(dstn_path)
  }

}
