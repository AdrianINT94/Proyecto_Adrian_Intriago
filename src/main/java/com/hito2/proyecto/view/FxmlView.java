package com.hito2.proyecto.view;

import java.util.ResourceBundle;

public enum FxmlView {

    LOGIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    },

    ADMIN {
        @Override
        public String getTitle() {
            return "Panel Administrador";
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/AdminView.fxml";
        }
    },

    USER {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("user.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/User.fxml";
        }
    },

    // 🔴 👉 AÑADIR SOLO ESTO
    ALUMNOS {
        @Override
        public String getTitle() {
            return "Gestión de Alumnos";
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/AlumnosView.fxml";
        }
    },
    
     ALUMNO_FORM {
        @Override
        public String getTitle() {
                return "Alumno";
            }

        @Override
        public String getFxmlFile() {
             return "/fxml/AlumnoForm.fxml";
     }    
    };

    // =======================
    // MÉTODOS ABSTRACTOS
    // =======================

    public abstract String getTitle();

    public abstract String getFxmlFile();

    // =======================
    // RESOURCE BUNDLE
    // =======================

    protected String getStringFromResourceBundle(String key) {
        return ResourceBundle.getBundle("Bundle").getString(key);
    }
}
