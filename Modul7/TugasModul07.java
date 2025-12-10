private void appendFileTeks() {
    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(textArea.getText());
            writer.write("\n");
            JOptionPane.showMessageDialog(this, "Text berhasil ditambahkan ke file");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan text: " + ex.getMessage());
        }
    }
}
