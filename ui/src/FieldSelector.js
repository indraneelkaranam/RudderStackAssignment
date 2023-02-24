import InputField from "./Fields/InputField";
import SingleSelectField from "./Fields/SingleSelectField";
import React from "react";
import CheckBoxField from "./Fields/CheckBoxField";

const FieldSelector = (props) => {
    const {fieldType, fieldDetails, fieldKey, updateFormData, userFormData } = props;

    switch (fieldType) {
        case "input":
            return <InputField
                fieldDetails={fieldDetails}
                fieldKey={fieldKey}
                updateFormData={updateFormData}
                userFormData={userFormData}/>
        case "singleSelect":
            return <SingleSelectField
                fieldDetails={fieldDetails}
                fieldKey={fieldKey}
                updateFormData={updateFormData}
                userFormData={userFormData}/>
        case "checkbox":
            return <CheckBoxField
                fieldDetails={fieldDetails}
                fieldKey={fieldKey}
                updateFormData={updateFormData}
                userFormData={userFormData}/>
    }
}

export default FieldSelector;