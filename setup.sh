#!/bin/bash

# FitForge Testing & Automation Setup Script

echo "=================================="
echo "FitForge Testing Setup"
echo "=================================="

# Install Maven if not present
if ! command -v mvn &> /dev/null; then
    echo "Installing Maven..."
    choco install maven -y
fi

# Download Grafana if not present
if [ ! -d "grafana" ]; then
    echo "Setting up Grafana..."
    mkdir grafana
    cd grafana
    
    # Download Grafana Windows standalone
    curl -L https://grafana.com/grafana/download -o grafana-installer.exe
    # Or if using WSL:
    # wget https://dl.grafana.com/oss/release/grafana-10.2.2.linux-amd64.tar.gz
    # tar xzf grafana-10.2.2.linux-amd64.tar.gz
    
    cd ..
fi

echo "Setup complete!"
echo ""
echo "Next steps:"
echo "1. Run tests: mvn clean test"
echo "2. Start Grafana: ./grafana/bin/grafana-server"
echo "3. Access Grafana at: http://localhost:3000"
