package com.ecommerce.ingestion

import com.ecommerce.utils.{SparkSessionUtil, StructSchemaUtil}

object ProductsRawIngestion {
  private val orig_path = "data_source/products/olist_products_dataset.csv"
  private val dstn_path = "data/raw/products/"

  val df_products = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .schema(StructSchemaUtil.products_schema)
    .csv(orig_path)

  def productsRawIngestion(): Unit = {
    //df_products.coalesce(1).write.mode("append").csv(dstn_path)
  }

}
