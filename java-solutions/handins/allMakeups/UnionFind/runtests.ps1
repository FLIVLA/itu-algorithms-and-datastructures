$inFiles = Get-ChildItem -Path . -Filter *.in
foreach ($file in $inFiles) {
    Write-Host "Test case $file"
    Get-Content $file.FullName | java .\UnionFind.java
}