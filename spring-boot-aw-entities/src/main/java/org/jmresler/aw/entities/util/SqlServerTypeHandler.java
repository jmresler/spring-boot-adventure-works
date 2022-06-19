package org.jmresler.aw.entities.util;

import com.microsoft.sqlserver.jdbc.Geography;
import com.microsoft.sqlserver.jdbc.Geometry;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class SqlServerTypeHandler {

    public static Geography toGeography(final byte[] geoLocation) throws SQLServerException {
        return Geography.deserialize(geoLocation);
    }

    public static Geometry toGeometry(final byte[] shape) throws SQLServerException {
        return Geometry.deserialize(shape);
    }


}
