package com.github.catsoftware.engine.tiles.tiled;

import com.github.catsoftware.engine.tiles.LoaderMap;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class TiledLoaderMap implements LoaderMap {

    private final Document document;

    public TiledLoaderMap(String path) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File(path);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(xmlFile);
    }

    public Map createMap() {
        Map map = new Map();
        TileSet tileSet = new TileSet();

        // tag: <map>
        NodeList rootNode = document.getElementsByTagName("map");
        Node mapNode = rootNode.item(0);

        // Atributos da tag: <map>
        NamedNodeMap mapAttr = mapNode.getAttributes();
        for (int i = 0; i < mapAttr.getLength(); i++) {
            if (mapAttr.item(i).getNodeType() == Node.ATTRIBUTE_NODE) {
                Attr attr = (Attr) mapAttr.item(i);
                if (attr.getName().equals("width"))
                    map.setWidth(Integer.parseInt(attr.getValue()));
                if (attr.getName().equals("height"))
                    map.setHeight(Integer.parseInt(attr.getValue()));
                if (attr.getName().equals("tilewidth"))
                    map.setTilewidth(Integer.parseInt(attr.getValue()));
                if (attr.getName().equals("tileheight"))
                    map.setTileheight(Integer.parseInt(attr.getValue()));
            }
        }

        // tag: <tileset>
        NodeList tileset = document.getElementsByTagName("tileset");
        NamedNodeMap tileSetAttr = tileset.item(0).getAttributes();
        for (int i = 0; i < tileSetAttr.getLength(); i++) {
            if (tileSetAttr.item(i).getNodeType() == Node.ATTRIBUTE_NODE) {
                Attr attr = (Attr) tileSetAttr.item(i);
                if (attr.getName().equals("firstgid"))
                    tileSet.setFirstGid(Integer.parseInt(attr.getValue()));
                if (attr.getName().equals("source")) {
                    tileSet.setSource(attr.getValue());
                }
            }
        }

        // tag: <Layer>
        NodeList layerNode = document.getElementsByTagName("layer");
        for (int i = 0; i < layerNode.getLength(); i++) {
            Layer layer = new Layer();
            NamedNodeMap layerAttr = layerNode.item(i).getAttributes();

            for(int j = 0; j < layerAttr.getLength(); j++) {
                Attr attr = (Attr) layerAttr.item(j);
                if(attr.getName().equals("id"))
                    layer.setId(Integer.parseInt(attr.getValue()));
                if(attr.getName().equals("name"))
                    layer.setName(attr.getValue());
                if(attr.getName().equals("width"))
                    layer.setWidth(Integer.parseInt(attr.getValue()));
                if(attr.getName().equals("height"))
                    layer.setHeight(Integer.parseInt(attr.getValue()));
                if(attr.getName().equals("offsetx"))
                    layer.setOffsetx(Integer.parseInt(attr.getValue()));
                if(attr.getName().equals("offsety"))
                    layer.setOffsety(Integer.parseInt(attr.getValue()));
            }

            // Pega os dados da layer e converte para um array de inteiros
            String[] strData = layerNode.item(i).getTextContent().trim().split(",");
            int[] data = new int[layer.getWidth() * layer.getHeight()];

            for(int dataIndex = 0; dataIndex < strData.length; dataIndex++) {
                data[dataIndex] = Integer.parseInt(strData[dataIndex].trim());
            }

            // Set o array de dados da layer e adiciona no mapa.
            layer.setData(data);
            map.addLayer(layer);
        }

        map.setTileSet(tileSet);
        return map;
    }
}
