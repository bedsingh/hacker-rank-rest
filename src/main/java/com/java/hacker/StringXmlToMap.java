
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/************************************************************************************************************
 * Created by IntelliJ IDEA.
 * User: Bed Singh
 * Date: 8/23/21 5:35 PM
 * To change this template use Preferences | Editor | File and Code Templates | Includes tab.
 *
 ************************************************************************************************************/

public class StringXmlToMap {

    public static void main(String[] args) {
        Map<String, Object> eventDataMap = parseStringXmlToDocument(getXmlString());
        eventDataMap.forEach((key, value) -> {
            System.out.println("Key = " + key + ",   Value = " + value);
        });
    }

    private static Map<String, Object> parseStringXmlToDocument(String xmlStr) {
        final Map<String, Object> eventDataMap = new ConcurrentHashMap<>();
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(new InputSource(new StringReader(xmlStr)));
            boolean isPresent = Optional.ofNullable(xmlDocument).isPresent();
            if (isPresent) {
                final NodeList childList = xmlDocument.getFirstChild().getChildNodes();
                Node child;
                for (int index = 0; index < childList.getLength(); index++) {
                    child = childList.item(index);
                    if (child.getTextContent() != null && child.getTextContent().trim().length() > 0) {
                        eventDataMap.put(child.getNodeName(), child.getTextContent());
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Exception in parsing xml string, errorMsg: " + exception.getMessage());
        }

        return eventDataMap;
    }

    private static String getXmlString() {

        return "<ExtractEventData>\n" +
                "        <StoreNumber>66000060</StoreNumber>\n" +
                "        <LaneNumber>L502</LaneNumber>\n" +
                "        <ExtractType>GreenButton</ExtractType>\n" +
                "        <SignatureList>ARC9651_ARC14577_ARC18984</SignatureList>\n" +
                "        <ProductName>Kroger CHEC Lane Extensions</ProductName>\n" +
                "        <Version>6.8.4861.1</Version>\n" +
                "        <InstalledPath>C:\\IBMSelfcheckout</InstalledPath>\n" +
                "        <InstallationDate>2017-04-28 13:28:37</InstallationDate>\n" +
                "        <Description>Kroger CHEC Lane Extensions</Description>\n" +
                "        <BuildNumber>4861.1</BuildNumber>\n" +
                "        <ExtractFile>C:/Toshiba/pythonProject/fileMonitor/Extract_Dump/ScanExtract/extractDir/SCS_Extract_Lane_S66000060_L502_RMA Default Policy_Jul142017_160937_GMT-07-00 AR14577_.zip</ExtractFile>\n" +
                "        <TimeStamp>Mon Aug 23 15:38:45 2021</TimeStamp>\n" +
                "</ExtractEventData>";
    }

}

/*
Output
Key = Description,   Value = Kroger CHEC Lane Extensions
Key = SignatureList,   Value = ARC9651_ARC14577_ARC18984
Key = ProductName,   Value = Kroger CHEC Lane Extensions
Key = LaneNumber,   Value = L502
Key = ExtractType,   Value = GreenButton
Key = InstallationDate,   Value = 2017-04-28 13:28:37
Key = TimeStamp,   Value = Mon Aug 23 15:38:45 2021
Key = BuildNumber,   Value = 4861.1
Key = ExtractFile,   Value = C:/Toshiba/pythonProject/fileMonitor/Extract_Dump/ScanExtract/extractDir/SCS_Extract_Lane_S66000060_L502_RMA Default Policy_Jul142017_160937_GMT-07-00 AR14577_.zip
Key = Version,   Value = 6.8.4861.1
Key = StoreNumber,   Value = 66000060
Key = InstalledPath,   Value = C:\IBMSelfcheckout
*/
