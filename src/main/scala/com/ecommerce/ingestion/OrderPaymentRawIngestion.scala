package com.ecommerce.ingestion

import com.ecommerce.utils.{SparkSessionUtil, StructSchemaUtil}

object OrderPaymentRawIngestion {
  private val orig_path = "data_source/order_payments/olist_order_payments_dataset.csv"
  private val dstn_path = "/order_payments/"

  val df_order_payments = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .option("inferSchema","true")
    .schema(StructSchemaUtil.order_payment_schema)
    .csv(orig_path)

  def orderPaymentsRawIngestion(): Unit = {
    //df_order_payments.coalesce(1).write.mode("append").csv(dstn_path)
  }

}
