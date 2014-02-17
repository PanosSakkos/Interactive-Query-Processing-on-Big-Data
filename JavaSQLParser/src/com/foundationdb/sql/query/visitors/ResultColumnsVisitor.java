/**
 * Copyright MaDgIK Group 2010 - 2013.
 */
package com.foundationdb.sql.query.visitors;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.ResultColumnList;
import com.foundationdb.sql.parser.Visitable;
import com.foundationdb.sql.query.SQLQuery;
import org.apache.log4j.Logger;

/**
 *
 * @author heraldkllapi
 */
public class ResultColumnsVisitor extends AbstractVisitor {
  private static final Logger log = Logger.getLogger(ResultColumnsVisitor.class);

  public ResultColumnsVisitor(SQLQuery query) {
    super(query);
  }

  @Override
  public Visitable visit(Visitable node) throws StandardException {
    if (node instanceof ResultColumnList) {
      ResultColumnVisitor columnVisitor = new ResultColumnVisitor(query);
      node.accept(columnVisitor);
      return node;
    }
    log.trace("Skip: " + node.getClass().getSimpleName());
    return node;
  }
}
