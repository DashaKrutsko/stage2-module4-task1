package com.mjc.stage2;

import java.io.IOException;
import java.sql.Connection;

public interface ConnectionFactory {
    Connection createConnection() throws IOException;
}
