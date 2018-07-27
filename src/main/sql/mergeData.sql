select 
 c.c_custkey,
 concat('"', cast (c.c_name as varchar(0)), '"') as c_name     ,                             
 concat('"', cast (c.c_address as varchar(0)), '"') as c_address  ,                             
 c.c_nationkey  ,                                
 concat('"', cast (c.c_phone as varchar(0)), '"') as c_phone    ,                             
 c.c_acctbal    ,                      
 concat('"', cast (c.c_mktsegment as varchar(0)), '"') as c_mktsegment,                             
 concat('"', cast (c.c_comment as varchar(0)), '"') as c_comment  ,                             
   o.o_orderkey,
   concat('"', cast (o.o_orderstatus as varchar(0)), '"') as o_orderstatus,
   o.o_totalprice,
   concat('"', cast (o.o_orderdate as varchar(0)), '"') as o_orderdate,
   concat('"', cast (o.o_orderpriority as varchar(0)), '"') as o_orderpriority,
   concat('"', cast (o.o_clerk as varchar(0)), '"') as o_clerk,
   o.o_shippriority,
   concat('"', cast (o.o_comment as varchar(0)), '"') as o_comment,
     l.l_partkey,
     l.l_suppkey,
     l.l_linenumber,
     l.l_quantity,
     l.l_extendedprice,
     l.l_discount,
     l.l_tax,
     concat('"', cast (l.l_returnflag as varchar(0)), '"') as l_returnflag,
     concat('"', cast (l.l_linestatus as varchar(0)), '"') as l_linestatus,
     concat('"', cast (l.l_shipdate as varchar(0)), '"') as l_shipdate,
     concat('"', cast (l.l_commitdate as varchar(0)), '"') as l_commitdate,
     concat('"', cast (l.l_receiptdate as varchar(0)), '"') as l_receiptdate,
     concat('"', cast (l.l_shipinstruct as varchar(0)), '"') as l_shipinstruct,
     concat('"', cast (l.l_shipmode as varchar(0)), '"') as l_shipmode,
     concat('"', cast (l.l_comment as varchar(0)), '"') as l_comment
from 
  dfs.data.`tpc-h/sf10/customer` c,
  dfs.data.`tpc-h/sf10/orders` o,
  dfs.data.`tpc-h/sf10/lineitem` l
where 
   c.c_custkey = o.o_custkey and
   o.o_orderkey = l.l_orderkey
   and c.c_custkey in ( 7180,   951313 )
order by c.c_custkey, o.o_orderkey
