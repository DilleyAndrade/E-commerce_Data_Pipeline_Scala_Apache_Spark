package com.ecommerce.utils

import org.apache.spark.sql.types.{StringType, StructType, TimestampType}

object StructSchemaUtil {
  val orders_schema = new StructType()
    .add("order_id",                      StringType)
    .add("customer_id",                   StringType)
    .add("order_status",                  StringType)
    .add("order_purchase_timestamp",      TimestampType)
    .add("order_approved_at",             TimestampType)
    .add("order_delivered_carrier_date",  TimestampType)
    .add("order_delivered_customer_date", TimestampType)
    .add("order_estimated_delivery_date", TimestampType)
}
