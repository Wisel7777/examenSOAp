package com.isi.examen.endpoint;

import com.isi.examen.model.Sector;
import com.isi.examen.service.ParametrageService;
import com.isi.examen.wsdl.GetSectorsResponse;
import com.isi.examen.wsdl.SectorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class ParametrageEndpoint {

    private static final String NAMESPACE = "http://example.com/parametrage";

    @Autowired
    private ParametrageService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "GetSectorsRequest")
    @ResponsePayload
    public GetSectorsResponse getSectors() {
        List<Sector> sectors = service.getAllSectors();
        GetSectorsResponse response = new GetSectorsResponse();
        for (Sector s : sectors) {
            SectorDto dto = new SectorDto();
            dto.setId(s.getId());
            dto.setName(s.getName());
            response.getSectors().add(dto);
        }
        return response;
    }
}
