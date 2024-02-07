#!/bin/bash

inFiles=$(find . -maxdepth 1 -type f -name "*.in")
for file in $inFiles; do
    echo "Test case $file"
    cat "$file" | dotnet fsi Atlogur.fsx
done