package com.mapr.tpch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Originally authored by Parth Chandra
Modified by Abhishek Girish
 */
public class ComplexJSON {

  public static class Customer {

    public String c_custkey;
    public String c_name;
    public String c_address;
    public String c_nationkey;
    public String c_phone;
    public String c_acctbal;
    public String c_mktsegment;
    public String c_comment;
    public List<Order> c_orders = new ArrayList<Order>();

    public String toJSON(int nestingLevel) {

      StringBuilder sb = new StringBuilder();
      sb.append("{ ");
      sb.append("\"C_CUSTKEY\" :").append("\"").append(c_custkey).append("\"").append(", ");
      sb.append("\"C_NAME\" :").append("\"").append(c_name).append("\"").append(", ");
      sb.append("\"C_ADDRESS\" :").append("\"").append(c_address).append("\"").append(", ");
      sb.append("\"C_NATIONKEY\" :").append(c_nationkey).append(", ");
      sb.append("\"C_PHONE\" :").append("\"").append(c_phone).append("\"").append(", ");
      sb.append("\"C_ACCTBAL\" :").append(c_acctbal).append(", ");
      sb.append("\"C_MKTSEGMENT\" :").append("\"").append(c_mktsegment).append("\"").append(", ");
      sb.append("\"C_COMMENT\" :").append("\"").append(c_comment).append("\"").append(", ");
      sb.append("\"C_ORDERS_KEYS\" :").append("[ ");
      for (int i = 0; i < c_orders.size(); i++) {
        Order o = c_orders.get(i);
        sb.append(o.toScalarList1());
        if (i < c_orders.size() - 1) {
          sb.append(", ");
        }
      }
      sb.append(" ], ");
      sb.append("\"C_ORDERS_CLERKS\" :").append("[ ");
      for (int i = 0; i < c_orders.size(); i++) {
        Order o = c_orders.get(i);
        sb.append(o.toScalarList2());
        if (i < c_orders.size() - 1) {
          sb.append(", ");
        }
      }
      sb.append(" ], ");
      sb.append("\"C_ORDERS_TOTALPRICE\" :").append("[ ");
      for (int i = 0; i < c_orders.size(); i++) {
        Order o = c_orders.get(i);
        sb.append(o.toScalarList3());
        if (i < c_orders.size() - 1) {
          sb.append(", ");
        }
      }
      sb.append(" ], ");
      sb.append("\"C_ORDERS_DATES\" :").append("[ ");
      for (int i = 0; i < c_orders.size(); i++) {
        Order o = c_orders.get(i);
        sb.append("{\"$dateday\" : ").append(o.toScalarList4()).append("}");
        if (i < c_orders.size() - 1) {
          sb.append(", ");
        }
      }
      sb.append(" ], ");
      sb.append("\"C_ORDERS\" :").append("[ ");
      for (int i = 0; i < c_orders.size(); i++) {
        Order o = c_orders.get(i);
        sb.append(o.toJSON(nestingLevel + 1));
        if (i < c_orders.size() - 1) {
          sb.append(",");
        }
      }
      sb.append(" ]");
      sb.append(" }").append("\n");

      return sb.toString();
    }
  }

  public static class Order {

    public String o_orderkey;
    public String o_orderstatus;
    public String o_totalprice;
    public String o_orderdate;
    public String o_orderpriority;
    public String o_clerk;
    public String o_shippriority;
    public String o_comment;
    public List<LineItem> o_lineitems = new ArrayList<LineItem>();

    public String toJSON(int nestingLevel) {

      StringBuilder sb = new StringBuilder();
      sb.append("{ ");
      sb.append("\"O_ORDERKEY\" :").append(o_orderkey).append(", ");
      sb.append("\"O_ORDERSTATUS\" :").append("\"").append(o_orderstatus).append("\"").append(", ");
      sb.append("\"O_TOTALPRICE\" :").append(o_totalprice).append(", ");
      sb.append("\"O_ORDERDATE\" :").append("\"").append(o_orderdate).append("\"").append(", ");
      sb.append("\"O_ORDERPRIORITY\" :").append("\"").append(o_orderpriority).append("\"").append(", ");
      sb.append("\"O_CLERK\" :").append("\"").append(o_clerk).append("\"").append(", ");
      sb.append("\"O_SHIPPRIORITY\" :").append(o_shippriority).append(", ");
      sb.append("\"O_COMMENT\" :").append("\"").append(o_comment).append("\"").append(", ");
      sb.append("\"O_KEYS\" :").append("{ ");
      if ( o_lineitems.size() > 0) {
        LineItem o = o_lineitems.get(0);
        sb.append(o.toKeysMap());
      }
      sb.append(" }, ");
      sb.append("\"O_TAXES\" :").append("[ ");
      for (int i = 0; i < o_lineitems.size(); i++) {
        LineItem l = o_lineitems.get(i);
        sb.append(l.toScalarList());
        if (i < o_lineitems.size() - 1) {
          sb.append(",");
        }
      }
      sb.append(" ], ");
      sb.append("\"O_DATES\" :").append("{ ");
      if ( o_lineitems.size() > 0) {
        LineItem o = o_lineitems.get(0);
        sb.append(o.toDatesMap());
      }
      sb.append(" }, ");
      sb.append("\"O_SHIPS\" :").append("{ ");
      if ( o_lineitems.size() > 0) {
        LineItem o = o_lineitems.get(0);
        sb.append(o.toShipMap());
      }
      sb.append(" }, ");
      sb.append("\"O_PRICES\" :").append("{ ");
      if ( o_lineitems.size() > 0) {
        LineItem o = o_lineitems.get(0);
        sb.append(o.toPriceMap());
      }
      sb.append(" }, ");
      sb.append("\"O_LINEITEMS\" :").append(" [ ");
      for (int i = 0; i < o_lineitems.size(); i++) {
        LineItem l = o_lineitems.get(i);
        sb.append(l.toJSON());
        if (i < o_lineitems.size() - 1) {
          sb.append(",");
        }
      }
      sb.append(" ]");
      sb.append(" }");

      return sb.toString();
    }

    public String toScalarList1() {

      StringBuilder sb = new StringBuilder();
      sb.append(o_orderkey);

      return sb.toString();
    }

    public String toScalarList2() {

      StringBuilder sb = new StringBuilder();
      sb.append("\"").append(o_clerk).append("\"");

      return sb.toString();
    }

    public String toScalarList3() {

      StringBuilder sb = new StringBuilder();
      sb.append(o_totalprice);

      return sb.toString();
    }

    public String toScalarList4() {

      StringBuilder sb = new StringBuilder();
      sb.append("\"").append(o_orderdate).append("\"");

      return sb.toString();
    }
  }

  public static class LineItem {

    public String l_partkey;
    public String l_suppkey;
    public String l_linenumber;
    public String l_quantity;
    public String l_extendedprice;
    public String l_discount;
    public String l_tax;
    public String l_returnflag;
    public String l_linestatus;
    public String l_shipdate;
    public String l_commitdate;
    public String l_receiptdate;
    public String l_shipinstruct;
    public String l_shipmode;
    public String l_comment;

    public String toJSON() {

      StringBuilder sb = new StringBuilder();
      sb.append("{ ");
      sb.append("\"L_PARTKEY\" :").append(l_partkey).append(", ");
      sb.append("\"L_SUPPKEY\" :").append(l_suppkey).append(", ");
      sb.append("\"L_LINENUMBER\" :").append(l_linenumber).append(", ");
      sb.append("\"L_QUANTITY\" :").append(l_quantity).append(", ");
      sb.append("\"L_EXTENDEDPRICE\" :").append(l_extendedprice).append(", ");
      sb.append("\"L_DISCOUNT\" :").append(l_discount).append(", ");
      sb.append("\"L_TAX\" :").append(l_tax).append(", ");
      sb.append("\"L_RETURNFLAG\" :").append("\"").append(l_returnflag).append("\"").append(", ");
      sb.append("\"L_LINESTATUS\" :").append("\"").append(l_linestatus).append("\"").append(", ");
      sb.append("\"L_SHIPDATE\" :").append("{\"$dateday\" : ").append("\"").append(l_shipdate).append("\"}").append(", ");
      sb.append("\"L_COMMITDATE\" :").append("{\"$dateday\" : ").append("\"").append(l_commitdate).append("\"}").append(", ");
      sb.append("\"L_RECEIPTDATE\" :").append("{\"$dateday\" : ").append("\"").append(l_receiptdate).append("\"}").append(", ");
      sb.append("\"L_SHIPINSTRUCT\" :").append("\"").append(l_shipinstruct).append("\"").append(", ");
      sb.append("\"L_SHIPMODE\" :").append("\"").append(l_shipmode).append("\"").append(", ");
      sb.append("\"L_COMMENT\" :").append("\"").append(l_comment).append("\"");
      sb.append(" }");

      return sb.toString();
    }

    public String toScalarList() {

      StringBuilder sb = new StringBuilder();
      sb.append(l_tax);

      return sb.toString();
    }

    public String toKeysMap() {

      StringBuilder sb = new StringBuilder();
      sb.append("\"L_PARTKEY\" :").append(l_partkey).append(", ");
      sb.append("\"L_SUPPKEY\" :").append(l_suppkey);

      return sb.toString();
    }

    public String toDatesMap() {

      StringBuilder sb = new StringBuilder();
      sb.append("\"L_SHIPDATE\" :").append("{\"$dateday\" : ").append("\"").append(l_shipdate).append("\"}").append(", ");
      sb.append("\"L_COMMITDATE\" :").append("{\"$dateday\" : ").append("\"").append(l_commitdate).append("\"}").append(", ");
      sb.append("\"L_RECEIPTDATE\" :").append("{\"$dateday\" : ").append("\"").append(l_receiptdate).append("\"}");

      return sb.toString();
    }

    public String toShipMap() {

      StringBuilder sb = new StringBuilder();
      sb.append("\"L_SHIPINSTRUCT\" :").append("\"").append(l_shipinstruct).append("\"").append(", ");
      sb.append("\"L_SHIPMODE\" :").append("\"").append(l_shipmode).append("\"");

      return sb.toString();
    }

    public String toPriceMap() {

      StringBuilder sb = new StringBuilder();
      sb.append("\"L_QUANTITY\" :").append(l_quantity).append(", ");
      sb.append("\"L_EXTENDEDPRICE\" :").append(l_extendedprice).append(", ");
      sb.append("\"L_DISCOUNT\" :").append(l_discount).append(", ");
      sb.append("\"L_TAX\" :").append(l_tax);

      return sb.toString();
    }

  }

  public static void main(String[] args) throws IOException {

    if (args.length != 2) {
      System.out.println("Usage: java ComplexJSON <inputFile> <outputFilePath>");
    }
    String inputFile = args[0];
    String outputFilePath = args[1];

    FileWriter fileWriter = new FileWriter(new File(outputFilePath), false);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    InputStream inputStream = new FileInputStream(inputFile);
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

    List<String> columns;
    String custKey, prevCustKey = "";
    String orderKey, prevOrderKey = "";

    Customer c = null;
    Order o = null;
    LineItem l = null;

    csv csvReader = new csv(true, '|', inputStreamReader);

    int i = 0;
    while (csvReader.hasNext()) {
      columns = csvReader.next();
      custKey = columns.get(0);
      orderKey = columns.get(8);
      if (!prevCustKey.equals(custKey)) {
        if (c != null) {
          bufferedWriter.write(c.toJSON(0));
        }
        c = new Customer();
        c.c_custkey = columns.get(0);
        c.c_name = columns.get(1);
        c.c_address = columns.get(2);
        c.c_nationkey = columns.get(3);
        c.c_phone = columns.get(4);
        c.c_acctbal = columns.get(5);
        c.c_mktsegment = columns.get(6);
        c.c_comment = columns.get(7);
      }
      if (c != null && !prevOrderKey.equals(orderKey)) {
        o = new Order();
        o.o_orderkey = columns.get(8);
        o.o_orderstatus = columns.get(9);
        o.o_totalprice = columns.get(10);
        o.o_orderdate = columns.get(11);
        o.o_orderpriority = columns.get(12);
        o.o_clerk = columns.get(13);
        o.o_shippriority = columns.get(14);
        o.o_comment = columns.get(15);
        c.c_orders.add(o);
        prevOrderKey = orderKey;
      }
      l = new LineItem();
      l.l_partkey = columns.get(16);
      l.l_suppkey = columns.get(17);
      l.l_linenumber = columns.get(18);
      l.l_quantity = columns.get(19);
      l.l_extendedprice = columns.get(20);
      l.l_discount = columns.get(21);
      l.l_tax = columns.get(22);
      l.l_returnflag = columns.get(23);
      l.l_linestatus = columns.get(24);
      l.l_shipdate = columns.get(25);
      l.l_commitdate = columns.get(26);
      l.l_receiptdate = columns.get(27);
      l.l_shipinstruct = columns.get(28);
      l.l_shipmode = columns.get(29);
      l.l_comment = columns.get(30);
      o.o_lineitems.add(l);
      prevCustKey = custKey;
    }

    bufferedWriter.write(c.toJSON(0));

    bufferedWriter.flush();
    fileWriter.flush();

    bufferedWriter.close();
    fileWriter.close();
    inputStream.close();
  }
}

