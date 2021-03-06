package org.suntao.easyorm.xmlparse;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.suntao.easyorm.configuration.DatabaseConfig;
import org.suntao.easyorm.configuration.XmlParse;
import org.suntao.easyorm.map.MapStatement;
import org.w3c.dom.Document;

/**
 * XMLParse单元测试
 * 
 * @author suntao
 *
 */
public class xmlparsetest {
	static String xmlpath = "src/test/resources/xmltest.xml";
	Document xmldoc;

	@Before
	public void setUp() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setValidating(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		xmldoc = builder.parse(xmlpath);
	}

	@Test
	public void testDBConfigParse() {
		DatabaseConfig databaseConfig = XmlParse.parseDataBaseConfig(xmldoc);
		System.out.println(databaseConfig.getInfoStr());
		Assert.assertNotNull(databaseConfig);
	}

	@Test
	public void testMapperXmlParse() {
		System.out.println("------------dao sql config--------------");
		Map<String, MapStatement> statments = XmlParse
				.mapStatmentsParse(new File(
						"src/test/java/org/suntao/easyorm/testMapper/courseInfoMapper.xml"));

		for (String key : statments.keySet()) {
			System.out.println(String.format("%s %s", statments.get(key)
					.getId(), statments.get(key).getStatmentSQL()));
		}
		System.out.println("-----------------end-------------------");
	}
}
