package pentaho;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
import org.olap4j.CellSet;
import org.olap4j.OlapConnection;
import org.olap4j.OlapStatement;
import org.olap4j.OlapWrapper;
import org.olap4j.layout.CellSetFormatter;
import org.olap4j.layout.RectangularCellSetFormatter;
import org.olap4j.metadata.Cube;
import org.olap4j.metadata.NamedList;*/

public class XMLADriver {/*
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.olap4j.driver.xmla.XmlaOlap4jDriver");
		Connection rconnection =
				DriverManager.getConnection(
				"jdbc:xmla:" +
				"Server=http://localhost:8080/pentaho/Xmla;Provider=mondrian;Catalog=SteelWheels;Datasource=SampleData;",
				"joe", "password");
		
		OlapConnection oconnection= rconnection.unwrap(OlapConnection.class);
		oconnection.setCatalog("SteelWheels");
		System.out.println(oconnection.getOlapCatalog());;
		//oconnection.getOlapCatalog().getSchemas().getName();
		OlapStatement stmt = oconnection.createStatement();
		String mdx = "Select {[Measures].[Quantity],[Measures].[Sales]} on COLUMNS,{[Customers].[Customer].[CUSTOMERNAME]}on ROWS from [SteelWheelsSales]";
		CellSet result = stmt.executeOlapQuery(mdx);
		//XmlaOlap4jCellSet	
		System.out.println(result);
		//while(result.next())
		//{
		//	System.out.println(result.getDouble(1));
		//}
		
		CellSetFormatter formatter = new
				RectangularCellSetFormatter(true);
				formatter.format(
						result,
				new PrintWriter(System.out, true));
		//NamedList<Cube>cubes=oconnection.getOlapSchema().getCubes();
		//System.out.println(cubes);
		
		
	}

*/}
