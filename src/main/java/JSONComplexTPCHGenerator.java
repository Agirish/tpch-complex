package tpch_complex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JSONComplexTPCHGenerator {


  public static char DELIMITER = ',';
  public static String TAB = "  ";

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

    public String toJSON(int nestingLevel){
      StringBuilder sb = new StringBuilder();
      String initSpace = "", spaces = TAB;
      for(int i = 0; i < nestingLevel; i++){
        initSpace += TAB;
      }
      spaces =spaces + initSpace;

      sb.append(initSpace).append("{").append("\n");
      sb.append(spaces).append("\"c_custkey\" :").append("\"").append(c_custkey).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"c_name\" :").append("\"").append(c_name).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"c_address\" :").append("\"").append(c_address).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"c_nationkey\" :").append(c_nationkey).append(",").append("\n");
      sb.append(spaces).append("\"c_phone\" :").append("\"").append(c_phone).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"c_acctbal\" :").append(c_acctbal).append(",").append("\n");
      sb.append(spaces).append("\"c_mktsegment\" :").append("\"").append(c_mktsegment).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"c_comment\" :").append("\"").append(c_comment).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"c_orders\" :").append("[").append("\n");
      for(int i =0; i < c_orders.size(); i++ ) {
        Order o = c_orders.get(i);
        sb.append(o.toJSON(nestingLevel + 1));
        if (i < c_orders.size() - 1) {
          sb.append(",");
        }
        sb.append("\n");
      }
      sb.append(spaces).append("]").append("\n");
      sb.append(initSpace).append("}").append("\n");

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

    public String toJSON(int nestingLevel){
      StringBuilder sb = new StringBuilder();
      String initSpace = "", spaces = TAB;
      for(int i = 0; i < nestingLevel; i++){
        initSpace += TAB;
      }
      spaces =spaces + initSpace;

      sb.append(initSpace).append("{").append("\n");
      sb.append(spaces).append("\"o_orderkey\" :").append(o_orderkey).append(",").append("\n");
      sb.append(spaces).append("\"o_orderstatus\" :").append("\"").append(o_orderstatus).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"o_totalprice\" :").append(o_totalprice).append(",").append("\n");
      sb.append(spaces).append("\"o_orderdate\" :").append("\"").append(o_orderdate).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"o_orderpriority\" :").append("\"").append(o_orderpriority).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"o_clerk\" :").append("\"").append(o_clerk).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"o_shippriority\" :").append(o_shippriority).append(",").append("\n");
      sb.append(spaces).append("\"o_comment\" :").append("\"").append(o_comment).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"o_lineitems\" :").append("[").append("\n");
      for(int i =0; i < o_lineitems.size(); i++ ) {
        LineItem l  = o_lineitems.get(i);
        sb.append(l.toJSON(nestingLevel + 1));
        if (i < o_lineitems.size() - 1) {
          sb.append(",");
        }
        sb.append("\n");
      }
      sb.append(spaces).append("]").append("\n");
      sb.append(initSpace).append("}").append("");

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

    public String toJSON(int nestingLevel){
      StringBuilder sb = new StringBuilder();
      String initSpace = "", spaces = TAB;
      for(int i = 0; i < nestingLevel; i++){
        initSpace += TAB;
      }
      spaces =spaces + initSpace;

      sb.append(initSpace).append("{").append("\n");

      sb.append(spaces).append("\"l_partkey\" :").append(l_partkey).append(",").append("\n");
      sb.append(spaces).append("\"l_suppkey\" :").append(l_suppkey).append(",").append("\n");
      sb.append(spaces).append("\"l_linenumber\" :").append(l_linenumber).append(",").append("\n");
      sb.append(spaces).append("\"l_quantity\" :").append(l_quantity).append(",").append("\n");
      sb.append(spaces).append("\"l_extendedprice\" :").append(l_extendedprice).append(",").append("\n");
      sb.append(spaces).append("\"l_discount\" :").append(l_discount).append(",").append("\n");
      sb.append(spaces).append("\"l_tax\" :").append(l_tax).append(",").append("\n");
      sb.append(spaces).append("\"l_returnflag\" :").append("\"").append(l_returnflag).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"l_linestatus\" :").append("\"").append(l_linestatus).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"l_shipdate\" :").append("\"").append(l_shipdate).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"l_commitdate\" :").append("\"").append(l_commitdate).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"l_receiptdate\" :").append("\"").append(l_receiptdate).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"l_shipinstruct\" :").append("\"").append(l_shipinstruct).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"l_shipmode\" :").append("\"").append(l_shipmode).append("\"").append(",").append("\n");
      sb.append(spaces).append("\"l_comment\" :").append("\"").append(l_comment).append("\"").append("").append("\n");
      sb.append(initSpace).append("}").append("");

      return sb.toString();

    }
  }

  public static void main(String[] args) throws IOException {

    if(args.length != 2) {
      System.out.println("Usage: ParquetComplexTPCHGenerator inputFile outputFile");
    }
    String inputFile = args[0];
    String outputFile = args[1];

    FileWriter fileWriter = new FileWriter( new File(outputFile), false);
    BufferedWriter writer = new BufferedWriter(fileWriter);
    InputStream is = new FileInputStream(inputFile);
    InputStreamReader reader = new InputStreamReader(is);

    //String line;
    List<String> columns;
    String custKey, prevCustKey="";
    String orderKey, prevOrderKey="";

    Customer c = null;
    Order o = null;
    LineItem l = null;
    csv csvReader = new csv(true, DELIMITER, reader);
    if(csvReader.hasNext()) {
      List<String> headers = csvReader.next(); // keep headers
    }
    int i = 0;
    while(csvReader.hasNext()) {
      System.out.print("Reading record: [" + ++i  + "]");
      columns = csvReader.next();
      custKey = columns.get(0);
      orderKey = columns.get(8);
      System.out.println("\t CustKey : " + custKey);
      if (!prevCustKey.equals(custKey)) {
        if (c != null) {
          writer.write(c.toJSON(0));
          //System.out.println(c.toJSON(1));
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
    writer.write(c.toJSON(0));

    writer.flush();
    fileWriter.flush();

    writer.close();
    fileWriter.close();
    is.close();
  }

}
