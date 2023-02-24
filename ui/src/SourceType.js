import React from "react";
import _ from "lodash";

/**
 * Drop Down for Source Type
 */
const SourceType = (props) => {
    const {sourceTypes} = props;
    return (
        <>
            <select name="sourceType" required className="select-box"
                    onChange={(e) => props.setCurrentSourceType(e.target.value)}>
                <option value="" selected disabled hidden>Select an Option</option>
                {_.map(sourceTypes, (sourceType) => (
                    <option value={sourceType}>{sourceType}</option>))}
            </select>
        </>
    )
}

export default SourceType;