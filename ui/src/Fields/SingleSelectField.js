import React from "react";
import _ from "lodash";

/**
 * Component for Select Drop Down
 * @param props -- props containing field details, field key, user responses
 * @returns {JSX.Element}
 */
const SingleSelectField = (props) => {
    const {fieldDetails, fieldKey, updateFormData, userFormData} = props;
    return (
        <div className="field">
            <div className="label-div"><label className="label">{fieldDetails.label}</label></div>
            <div className="content-div">
                <select className="select-box"
                        onChange={(e) => updateFormData(fieldKey, e.target.value)}
                        required={_.isNil(fieldDetails.required) ? false : fieldDetails.required}
                        value={_.get(userFormData, fieldKey)}>
                    <option value="" selected disabled hidden>Select an Option</option>
                    {_.map(fieldDetails.options, (option) => (
                        <option value={option.value}>{option.label}</option>))}
                </select>
            </div>
        </div>
    );
}

export default SingleSelectField;
