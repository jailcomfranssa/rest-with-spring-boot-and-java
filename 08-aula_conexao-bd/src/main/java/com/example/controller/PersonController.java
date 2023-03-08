package com.example.controller;

import com.example.data.vo.v1.PersonVO;
import com.example.data.vo.v2.PersonVOV2;
import com.example.services.PersonServices;
import com.example.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for Managing People")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(summary = "Finds all People",
               description = "Finds all People",
               tags = {"People"},
               responses = {@ApiResponse(description = "Success", responseCode = "200",
                       content = { @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
                    )
            }),
            @ApiResponse(description = "Bad Request"    , responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized"   , responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found"      , responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error" , responseCode = "500", content = @Content)
    }
    )
    public List<PersonVO> findAll() {

        return service.findAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
                 consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(summary = "Adds a new Person",
            description = "Finds a People",
            tags = {"People"},
            responses = {@ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "Bad Request"    , responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized"   , responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error" , responseCode = "500", content = @Content)
            }
    )
    public PersonVO create(@RequestBody PersonVO person) {

        return service.create(person);
    }

    @PostMapping(value = "/v2", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
                                   consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }
    )
    @Operation(summary = "Finds add new People",
            description = "Finds a People",
            tags = {"People"},
            responses = {@ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = PersonVO.class))
            ),
                    @ApiResponse(description = "Bad Request"    , responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found"      , responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error" , responseCode = "500", content = @Content)
            }
    )
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {

        return service.createV2(person);
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
                consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }
    )
    @Operation(summary = "Finds a update People",
            description = "Finds a People",
            tags = {"People"},
            responses = {@ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = PersonVO.class))
            ),
                    @ApiResponse(description = "No Content"    , responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request"    , responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized"   , responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found"      , responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error" , responseCode = "500", content = @Content)
            }
    )
    public PersonVO update(@RequestBody PersonVO person) {

        return service.update(person);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(summary = "Finds a People",
            description = "Finds a People",
            tags = {"People"},
            responses = {@ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = PersonVO.class))
            ),
                    @ApiResponse(description = "No Content"    , responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request"    , responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized"   , responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found"      , responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error" , responseCode = "500", content = @Content)
            }
    )
    public PersonVO findbyId(@PathVariable(value = "id") Long id) {

        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Finds delete People",
            description = "Finds a People",
            tags = {"People"},
            responses = {@ApiResponse(description = "No Content", responseCode = "204", content = @Content
            ),
                    @ApiResponse(description = "Bad Request"    , responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized"   , responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found"      , responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error" , responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
