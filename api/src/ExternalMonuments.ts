export interface ExternalMonuments {
    records : Array<Records>,
}

interface Records {
    datasetid : string,
    recordid : string,
    fields : {
        insee : string,
        objectid_1 : string,
        lien_merim : string,
        objectid : string,
        dep : string,
        type_archi : string,
        nomcom : string,
        geo_point_2d : number[],
        st_lengthshape : string,
        geo_shape : {
            type : string,
            //coordinates, c'est un tableau contenant d'autres tableaux de nombres. Normalement, c'est un champ en plus de tout le reste, donc l'objet devrait être reconnu par l'interface
        }
        protection : string,
        immeuble : string,
        date_prot : Date,
        st_areashape : string,
        ref_merim : string,
        type_prot : string,
    }
    geometry : {
        type : string,
        coordinates : number[],
    }
    record_timestamp : Date,
}