import React from "react";
import _ from "lodash";

/**
 * Component for Input Field
 * @param props -- props containing field details, field key, user responses
 * @returns {JSX.Element}
 */
const InputField = (props) => {
    const { fieldDetails , fieldKey , updateFormData, userFormData } = props;
    return (
        <div className="field">
            <div className="label-div"><label className="label">{fieldDetails.label}</label></div>
            <div className="content-div">
                <input type="text"
                       pattern={fieldDetails?.regex}
                       className="input-field"
                       value={_.get(userFormData, fieldKey)}
                       required={_.isNil(fieldDetails.required) ? false : fieldDetails.required}
                       placeholder={fieldDetails?.placeholder}
                       onInvalid={(e) => !_.isNil(fieldDetails?.regex) ?
                           e.target.setCustomValidity(fieldDetails?.regexErrorMessage) : _.noop()}
                       onChange={(e) => {
                           updateFormData(fieldKey, e.target.value);
                           e.target.setCustomValidity('');
                       }}
                       onInput={(e) => e.target.setCustomValidity(' ')}
                />
            </div>
        </div>
    );
}

export default InputField;
