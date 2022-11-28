import React from "react";
import { withTranslation } from "react-i18next";
import { changeLanguage } from "../api/apiCalls";

const LanguageSelector = (props) => {
  const onChangeLanguage = (language) => {
    const { i18n } = props;
    i18n.changeLanguage(language);
    changeLanguage(language);
  };

  return (
    <div className="container">
      <img
        src="https://flagcdn.com
/
w40
/
tr
.
webp"
        alt="Turkish Flag"
        onClick={() => onChangeLanguage("tr")}
        style={{ cursor: "pointer" }}
      />
      <img
        src="https://flagcdn.com
/
w40
/
us
.
webp"
        alt="USA Flag"
        onClick={() => onChangeLanguage("en")}
        style={{ cursor: "pointer" }}
      />
    </div>
  );
};

export default withTranslation()(LanguageSelector);
