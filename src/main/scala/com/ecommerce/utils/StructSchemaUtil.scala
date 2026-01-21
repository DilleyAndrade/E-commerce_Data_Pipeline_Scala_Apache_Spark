package com.ecommerce.utils

import org.apache.spark.sql.types.{DoubleType, IntegerType, StringType, StructType, TimestampType}

object StructSchemaUtil {

  private val structType = new StructType()

  val orders_schema = structType
    .add("order_id",                      StringType)
    .add("customer_id",                   StringType)
    .add("order_status",                  StringType)
    .add("order_purchase_timestamp",      TimestampType)
    .add("order_approved_at",             TimestampType)
    .add("order_delivered_carrier_date",  TimestampType)
    .add("order_delivered_customer_date", TimestampType)
    .add("order_estimated_delivery_date", TimestampType)

  val products_schema = structType
    .add("product_id",                  StringType)
    .add("product_category_name",       StringType)
    .add("product_name_lenght",         IntegerType)
    .add("product_description_lenght",  IntegerType)
    .add("product_photos_qty",          IntegerType)
    .add("product_weight_g",            IntegerType)
    .add("product_length_cm",           IntegerType)
    .add("product_height_cm",           IntegerType)
    .add("product_width_cm",            IntegerType)

  val order_payment_schema = structType
    .add("order_id",              StringType)
    .add("payment_sequential",   IntegerType)
    .add("payment_type",         StringType)
    .add("payment_installments", IntegerType)
    .add("payment_value",        DoubleType)

  val order_items_schema = structType
    .add("order_id",            StringType)
    .add("order_item_id",       IntegerType)
    .add("product_id",          StringType)
    .add("seller_id",           StringType)
    .add("shipping_limit_date", TimestampType)
    .add("price",               DoubleType)
    .add("freight_value",       DoubleType)

}
