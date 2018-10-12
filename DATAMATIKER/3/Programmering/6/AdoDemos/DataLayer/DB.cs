using System;
using System.Configuration;

namespace DataLayer {

    public class DB {

        public enum OpMode {
            Unknown,
            SqlInline,
            SqlInlineParam,
            StoredProcedure
        };

        public static string DbConnectionString {
            get { return ConfigurationManager.ConnectionStrings["ConnectMsSqlString"].ToString();  }
        }

    }

}
