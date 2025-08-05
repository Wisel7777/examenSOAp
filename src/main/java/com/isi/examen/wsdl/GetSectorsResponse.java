package com.isi.examen.wsdl;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "GetSectorsResponse", namespace = "http://example.com/parametrage")
public class GetSectorsResponse {

    private List<SectorDto> sectors = new ArrayList<>();

    @XmlElement(name = "sectors")
    public List<SectorDto> getSectors() {
        return sectors;
    }

    public void setSectors(List<SectorDto> sectors) {
        this.sectors = sectors;
    }
}

