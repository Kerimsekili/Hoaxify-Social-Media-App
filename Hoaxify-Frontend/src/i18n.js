import i18next, { setDefaultNamespace } from "i18next";
import i18n from "i18next";
import { initReactI18next } from "react-i18next";

i18n.use(initReactI18next).init({
  resources: {
    en: {
      translations: {
        "Sign Up": "Sign Up",
        "Password mismatch": "Password mismatch",
        Username: "Username",
        Nickname: "Nickname",
        Password: "Password",
        "Password Repeat": "Password Repeat",
        Login: "Login",
      },
    },
    tr: {
      translations: {
        "Sign Up": "Kayıt Ol",
        "Password mismatch": "Parolalar Eşleşmiyor",
        Username: "Kullanıcı Adı",
        Nickname: "Takma Ad",
        Password: "Parola",
        "Password Repeat": "Parolayı Tekrarla",
        Login: "Sisteme Giriş",
      },
    },
  },
  fallbackLng: "tr",
  ns: ["translations"],
  setDefaultNamespace: "translations",
  keySeparator: false,
  interpolation: {
    escapeValue: false,
    formatSeparator: ",",
  },
  react: {
    wait: true,
  },
});

export default i18n;
